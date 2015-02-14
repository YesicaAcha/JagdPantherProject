package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import db.Database;
import framework.pages.HomePage;

public class VerifySetGradesToApplicants {
	Database db = new Database();

	/**
	 * Connect to the database and create a program
	 * @throws Exception
	 */
		@BeforeClass
		public void setUp() throws Exception {
			db.setUp();
			db.createStagesDB();
			db.createProgramsByBD();
			db.createGroupDB();
			db.createPeriodDB();
			db.createApplicantDB();	
		}

	/**
	 * This test case verifies program information is modified and displayed in Program Details Page 
	 * and this information is saved in the database
	 * @param name: Program's name
	 * @param title: Program's title
	 * @param description: Program's description
	 * @throws Exception
	 */
	@Test
	public void verifyApplicantsGradesCanBeSet() throws Exception {
		HomePage HomePage = new HomePage();
		String grade = "80";
		String applicantCI = "4900260";

		//Go to ProgramDetailsPage
		HomePage
		.clickPeriodsLink()
		.clickEditPeriodButton()
		.clickStagesButton()
		.clickGradeButton()
		.setGrade(grade)
		.clickSaveButton();

		Assert.assertEquals(db.getApplicantGrade(applicantCI), grade);
	}

	/**
	 * Delete Stage data from table
	 * @throws Exception
	 */
	@AfterClass
	public void closeConnection() throws Exception {
		//db.deleteDataFromDB();
		db.tearDown();
	}
}
