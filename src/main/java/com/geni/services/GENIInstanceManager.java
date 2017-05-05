package com.geni.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.BasicConfigurator;
import org.apache.struts2.ServletActionContext;

import com.jcabi.log.Logger;
import com.jcabi.ssh.SSH;
import com.jcabi.ssh.Shell;
import com.opensymphony.xwork2.ActionContext;

public class GENIInstanceManager {

	public String createVMInGENI() {

		String pythonScriptResult = null;
		ActionContext ctx = ActionContext.getContext();
		ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/python", "/Users/arjun_ac/Desktop/geni_deployment.py");
		pb.redirectErrorStream(true);

		System.out.println("Running the deployment script");
		try {
			Process process = pb.start();
			/*
			 * File f = new File("/Users/arjun_ac/Desktop/"); pb.directory(f);
			 */
			int errCode = process.waitFor();
			System.out.println("Echo command executed, any errors?" + (errCode == 0 ? "No" : "Yes"));
			// System.out.println("Echo output:\n" +
			// output(process.getInputStream()));
			pythonScriptResult = output(process.getInputStream());
			ServletActionContext.getResponse().getWriter().print(pythonScriptResult);
			System.out.println(pythonScriptResult);
			ctx.getSession().put("geniInstanceID", pythonScriptResult);
			
			String[] results = pythonScriptResult.split(" ");
			String [] temp = results[1].split(":");
			String server = temp[0];
			System.out.println("Server address of the GENI instance : " + server);
			System.out.println("Waiting for geni instance to come up");
			
			TimeUnit.SECONDS.sleep(200);
				
			System.out.println("wait completed, trying to install docker in geni");
			installDockerInGENI(server);
			
			return pythonScriptResult;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("python script error");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("python script error");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

	private String output(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.getProperty("line.separator"));
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}
	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	private void installDockerInGENI(String server) throws Exception {
		System.out.println("===========================================");
        System.out.println("Welcome to the CustomTemplate Migration Tool");
        System.out.println("===========================================");
        
        //configure the logger
        BasicConfigurator.configure();
        //String server = "pcvm3-3.geni.uchicago.edu";
        int port = 22;
        String user = "arjunank";
        String keyPath = "/Users/arjun_ac/.ssh/id_geni_ssh_rsa";
        String key = readFile(keyPath, StandardCharsets.UTF_8);
        String passPhrase = "arjun";
        String scriptPath = "/Users/arjun_ac/Desktop/migration_geni.sh";
        
        Shell shell = new SSH(server, port, user, key, passPhrase);
        InputStream stdin = null;
        
        File file = new File(scriptPath);
        int result = new Shell.Safe(shell).exec(
                    "cat > migration_geni.sh",
                    new FileInputStream(file),
                    Logger.stream(Level.INFO, shell),
                    Logger.stream(Level.WARNING, shell)
                  );

        System.out.println("result = " + result);
        result = new Shell.Safe(shell).exec(
          "chmod 744 migration_geni.sh",
          stdin,
          Logger.stream(Level.INFO, shell),
          Logger.stream(Level.WARNING, shell)
        );
        
        System.out.println("result = " + result);


        result = new Shell.Safe(shell).exec(
          "sudo apt-get install dos2unix",
          stdin,
          Logger.stream(Level.INFO, shell),
          Logger.stream(Level.WARNING, shell)
        );
        
        System.out.println("result = " + result);

        result = new Shell.Safe(shell).exec(
                "dos2unix migration_geni.sh",
                stdin,
                Logger.stream(Level.INFO, shell),
                Logger.stream(Level.WARNING, shell)
              );
              
              System.out.println("result = " + result);
        result = new Shell.Safe.Verbose(shell).exec(
        		"./migration_geni.sh",  
        		stdin,
        		Logger.stream(Level.INFO, shell),
                Logger.stream(Level.WARNING, shell));
        System.out.println("result = " + result);
        
        String grantAccess = "sudo usermod -aG docker " + user;
        result = new Shell.Safe.Verbose(shell).exec(
        		grantAccess,  
        		stdin,
        		Logger.stream(Level.INFO, shell),
                Logger.stream(Level.WARNING, shell));
        System.out.println("result = " + result);
        
        result = new Shell.Safe.Verbose(shell).exec(
        		"exit",  
        		stdin,
        		Logger.stream(Level.INFO, shell),
                Logger.stream(Level.WARNING, shell));
        System.out.println("result = " + result);           
      
		
        System.out.println("Migration Complete, Goodbye!\n");
	}
}
