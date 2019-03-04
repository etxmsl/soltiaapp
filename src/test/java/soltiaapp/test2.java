package soltiaapp;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import soltiaapp.se.IPageChrome;
import soltiaapp.se.StartPage;

public class test2 {
	StartPage soltiaapp = new StartPage(15);
	protected static WebDriver driver2; 

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		driver2=IPageChrome.startDriver();
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		IPageChrome.killDriver(driver2);
	}

	@BeforeEach
	public void app1loaded() {
	    boolean loaded = soltiaapp.waitForVisabilitybyid("menu-item-448");
		if (loaded) {
			boolean app1 = soltiaapp.findElementByidandclick("menu-item-448");
			if (app1) {
				soltiaapp.waitForVisabilitybyid("psw");
			}
		}	
	}

	@AfterEach
	public void reloadpage() {
		soltiaapp.loadpage();
	}

	/*
	 * @Before public void app1loaded (){ boolean
	 * loaded=soltiaapp.waitForVisabilitybyid("menu-item-448"); if (loaded){ boolean
	 * app1=soltiaapp.findElementByidandclick("menu-item-448"); if(app1){
	 * soltiaapp.waitForVisabilitybyid("psw"); } } }
	 */

	/*
	 * @After public void reloadpage(){ soltiaapp.loadpage(); }
	 */

	@Test
	public void tc5_Login_user() {
		boolean userloggedin = false;
		soltiaapp.findInputByIdandsendkeys("email", "semala02");
		soltiaapp.findInputByIdandsendkeys("psw", "kleven");
		boolean login = soltiaapp.findElementBynameandclick("loginuser");
		if (login) {
			boolean scansloaded = soltiaapp.waitForVisabilitybyid("scans");
			boolean economysystemsloaded = soltiaapp.waitForVisabilitybyid("economysystems");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (scansloaded && economysystemsloaded) {
				userloggedin = soltiaapp.findElementByidandclick("menu-item-451");
			}

		}
		// Assertions.assertTrue(userloggedin, () -> "User not logged in");
		Assertions.assertTrue(userloggedin, "User not logged in");
	}

}
