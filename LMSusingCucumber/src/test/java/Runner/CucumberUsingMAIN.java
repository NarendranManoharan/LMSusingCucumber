package Runner;


import io.cucumber.core.cli.Main;

public class CucumberUsingMAIN {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		Main.main(new String[]{"-g", "StepDefinitions", "src/test/java/Features/", "-m"});    

	}

}
