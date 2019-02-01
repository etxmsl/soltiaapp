package soltiaapp;

import org.junit.jupiter.api.*;
import soltiaapp.se.IPageChrome;
import soltiaapp.se.StartPage;

public class test2 {
	StartPage soltiaapp = new StartPage(15);

	@BeforeAll
	public static void setUpBeforeClass(StartPage soltiaapp) throws Exception {
		IPageChrome.startDriver();
		boolean loaded = soltiaapp.waitForVisabilitybyid("menu-item-448");
		if (loaded) {
			boolean app1 = soltiaapp.findElementByidandclick("menu-item-448");
			if (app1) {
				soltiaapp.waitForVisabilitybyid("psw");
			}
		}

	}

	@AfterAll
	public static void tearDownAfterClass(StartPage soltiaapp) throws Exception {
		soltiaapp.loadpage();
		IPageChrome.killDriver();
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
			if (scansloaded && economysystemsloaded) {
				userloggedin = soltiaapp.findElementByidandclick("menu-item-451");
			}

		}
		// Assertions.assertTrue(userloggedin, () -> "User not logged in");
		Assertions.assertTrue(userloggedin, "User not logged in");
	}

}
