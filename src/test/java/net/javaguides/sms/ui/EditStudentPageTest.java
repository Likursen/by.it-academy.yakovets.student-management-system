package net.javaguides.sms.ui;

import net.javaguides.sms.ui.object.Student;
import net.javaguides.sms.ui.pages.EditStudentsPage;
import net.javaguides.sms.ui.pages.StudentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditStudentPageTest extends BaseTest {

    @Test
    public void editStudentPageUITest() {
        int editStudentNumber = 1;
        EditStudentsPage editStudentsPage = new StudentsPage().openPage()
                .clickUpdateStudent(editStudentNumber);

        Assert.assertTrue(editStudentsPage.isHeaderPageDisplayed());
        Assert.assertTrue(editStudentsPage.isLabelsFirstNameDisplayed());
        Assert.assertTrue(editStudentsPage.isLabelsLastNameDisplayed());
        Assert.assertTrue(editStudentsPage.isLabelsEmailDisplayed());
        Assert.assertTrue(editStudentsPage.isButtonSubmitFormDisplayed());
    }

    @Test
    public void editStudentTest() {
        Student student = new Student("Ivan2", "Ivanov2", "Ivanov2@mail.com");
        int editStudentNumber = 1;
        StudentsPage studentsPage = new StudentsPage().openPage();
        Student notEditStudent = studentsPage.getStudentByNumber(editStudentNumber);

        boolean isEditStudentsPresent = studentsPage.clickUpdateStudent(editStudentNumber)
                .typeFirstName(student.getFirstName())
                .typeLastName(student.getLastName())
                .typeEmail(student.getEmail())
                .clickSubmit()
                .findStudent(notEditStudent);
        Assert.assertFalse(isEditStudentsPresent);
    }
}