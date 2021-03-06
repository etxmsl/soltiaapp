package soltiaapp;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import soltiaapp.se.IPageChrome;
import soltiaapp.se.StartPage;

public class test1 {
	
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
	 * @Before public void app1loaded() { boolean loaded =
	 * soltiaapp.waitForVisabilitybyid("menu-item-448"); if (loaded) { boolean app1
	 * = soltiaapp.findElementByidandclick("menu-item-448"); if (app1) {
	 * soltiaapp.waitForVisabilitybyid("psw"); } } }
	 */

	/*
	 * @After public void reloadpage() { soltiaapp.loadpage();
	 * IPageChrome.killDriver(); }
	 */

	@Test
	public void etc1_reg_company() {
		boolean regcompany = false;
		boolean name = soltiaapp.findInputByIdandsendkeys("name", "Krogen i Tumba AB");
		boolean orgnum = soltiaapp.findInputByIdandsendkeys("orgnum", "556906-6458");
		boolean address = soltiaapp.findInputByIdandsendkeys("address", "Tumba torg 116");
		boolean postnum = soltiaapp.findInputByIdandsendkeys("postnum", "14730");
		boolean postort = soltiaapp.findInputByIdandsendkeys("postort", "Tumba");
		boolean phone = soltiaapp.findInputByIdandsendkeys("phone", "0853034440");
		boolean psw = soltiaapp.findInputByIdandsendkeys("psw2", "kleven");
		if (name && orgnum && address && postnum && postort && phone && psw) {
			boolean register = soltiaapp.findElementBynameandclick("regcompany");
			if (register) {
				boolean rule = soltiaapp.waitForVisabilitybyid("rule");
				if (rule) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					regcompany = soltiaapp.findElementByidandclick("menu-item-451");
				}
			}
		}
		Assertions.assertTrue(regcompany, "Company Register failed");
	}

	@Test
	public void dtc2_reg_soltia() {
		boolean regsoltia = false;
		boolean name = soltiaapp.findInputByIdandsendkeys("name", "Soltia AB");
		boolean orgnum = soltiaapp.findInputByIdandsendkeys("orgnum", "556907-8347");
		boolean address = soltiaapp.findInputByIdandsendkeys("address", "Barkvägen 12");
		boolean postnum = soltiaapp.findInputByIdandsendkeys("postnum", "14752");
		boolean postort = soltiaapp.findInputByIdandsendkeys("postort", "Tumba");
		boolean phone = soltiaapp.findInputByIdandsendkeys("phone", "0707548227");
		boolean email = soltiaapp.findInputByIdandsendkeys("email2", "mir@soltia.com");
		boolean psw = soltiaapp.findInputByIdandsendkeys("psw2", "kleven");
		if (name && orgnum && address && postnum && postort && phone && email && psw) {
			boolean register = soltiaapp.findElementBynameandclick("regcompany");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (register) {
				boolean rule = soltiaapp.waitForVisabilitybyxpath("//input[@value='Soltia']");
				if (rule) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					regsoltia = soltiaapp.findElementByidandclick("menu-item-451");
				}
			}
		}

		Assertions.assertTrue(regsoltia, "Company Register failed");
	}

	@Test
	public void ctc3_add_user_company() {
		boolean addusercompany = false;
		soltiaapp.findInputByIdandsendkeys("orgnum2", "556906-6458");
		soltiaapp.findInputByIdandsendkeys("psw3", "kleven");
		boolean logincompany = soltiaapp.findElementBynameandclick("reguser");
		if (logincompany) {
			boolean name = soltiaapp.findInputByIdandsendkeys("name2", "Anette Klingborg");
			boolean user = soltiaapp.findInputByIdandsendkeys("user", "klingborg");
			boolean appuser = soltiaapp.findandClicCheckboxbyid("appuser");
			boolean reseller = soltiaapp.findElementByxpathandclick("//*[@value='Reseller']");
			boolean permissions = soltiaapp.findElementByxpathandclick("//*[@value='AddUser']");
			boolean admin = soltiaapp.findandClicCheckboxbyid("admin");
			boolean suspended = soltiaapp.findandClicCheckboxbyid("suspended");
			boolean email = soltiaapp.findInputByIdandsendkeys("e-mail", "anette@klingborg.se");
			boolean psw = soltiaapp.findInputByIdandsendkeys("psw2", "kleven");
			if (name && user && appuser && reseller && permissions && admin && suspended && email && psw) {
				boolean register = soltiaapp.findElementBynameandclick("reguser");
				if (register) {
					boolean scansloaded = soltiaapp.waitForVisabilitybyid("scans");
					boolean economysystemsloaded = soltiaapp.waitForVisabilitybyid("economysystems");
					if (scansloaded && economysystemsloaded) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						addusercompany = soltiaapp.findElementByidandclick("menu-item-451");
					}
				}
			}
		}
		Assertions.assertTrue(addusercompany, "Add user copmpany failed");
	}

	@Test
	public void btc4_add_user_soltia() {
		boolean addusersoltia = false;
		soltiaapp.findInputByIdandsendkeys("orgnum2", "556907-8347");
		soltiaapp.findInputByIdandsendkeys("psw3", "kleven");
		boolean logincompany = soltiaapp.findElementBynameandclick("reguser");
		if (logincompany) {
			boolean name = soltiaapp.findInputByIdandsendkeys("name2", "Martin Landhage");
			boolean user = soltiaapp.findInputByIdandsendkeys("user", "semala02");
			boolean appuser = soltiaapp.findandClicCheckboxbyid("appuser");
			boolean reseller = soltiaapp.findElementByxpathandclick("//*[@value='Soltia']");
			boolean permissions = soltiaapp.findElementByxpathandclick("//*[@value='AddReseller']");
			boolean admin = soltiaapp.findandClicCheckboxbyid("admin");
			boolean email = soltiaapp.findInputByIdandsendkeys("e-mail", "martin@soltia.com");
			boolean psw = soltiaapp.findInputByIdandsendkeys("psw2", "kleven");
			if (name && user && appuser && reseller && permissions && admin && email && psw) {
				boolean register = soltiaapp.findElementBynameandclick("reguser");
				if (register) {
					boolean scansloaded = soltiaapp.waitForVisabilitybyid("scans");
					boolean economysystemsloaded = soltiaapp.waitForVisabilitybyid("economysystems");
					if (scansloaded && economysystemsloaded) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						addusersoltia = soltiaapp.findElementByidandclick("menu-item-451");
					}
				}
			}
		}
		Assertions.assertTrue(addusersoltia, "Add user Soltia failed");
	}

}
