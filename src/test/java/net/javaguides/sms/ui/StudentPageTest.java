package net.javaguides.sms.ui;

import net.javaguides.sms.ui.object.Student;
import net.javaguides.sms.ui.pages.StudentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentPageTest extends BaseTest {

    @Test
    public void studentPageUITest() {
        int verifyStudentNumber = 1;
        StudentsPage studentsPage = new StudentsPage().openPage();

        Assert.assertTrue(studentsPage.isHeaderPageDisplayed());
        Assert.assertTrue(studentsPage.isTitlesFirstNameDisplayed());
        Assert.assertTrue(studentsPage.isTitlesLastNameDisplayed());
        Assert.assertTrue(studentsPage.isTitlesEmailDisplayed());
        Assert.assertTrue(studentsPage.isStudentUpdateButtonDisplayed(verifyStudentNumber));
        Assert.assertTrue(studentsPage.isStudentDeleteButtonDisplayed(verifyStudentNumber));
    }

    @Test
    public void studentDeleteTest() {
        int numberOfDeletedStudent = 1;

        StudentsPage studentsPage = new StudentsPage().openPage();
        Student copyOfDeletedStudent = studentsPage.getStudentByNumber(numberOfDeletedStudent);
        boolean findDeleteStudent = studentsPage.clickDeleteStudent(numberOfDeletedStudent)
                .findStudent(copyOfDeletedStudent);
        System.out.println(copyOfDeletedStudent.getFirstName());
        Assert.assertFalse(findDeleteStudent);
    }
}