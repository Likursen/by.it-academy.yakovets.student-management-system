package net.javaguides.sms.ui.pages;

import net.javaguides.sms.ui.object.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsPage extends BasePage {
    private final String baseUrl = "http://localhost:8080/students";

    @FindBy(xpath = "//h1")
    private WebElement headerPage;

    @FindBy(xpath = "//a[@href='/students/new']")
    private WebElement linkAddStudent;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[1]")
    private WebElement titlesFirstName;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[2]")
    private WebElement titlesLastName;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[3]")
    private WebElement titlesEmail;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered']//th[4]")
    private WebElement titlesAction;

    public StudentsPage openPage() {
        webDriver.get(baseUrl);
        return this;
    }

    public boolean isHeaderPageDisplayed() {
        return headerPage.isDisplayed();
    }

    public boolean isTitlesFirstNameDisplayed() {
        return titlesFirstName.isDisplayed();
    }

    public boolean isTitlesLastNameDisplayed() {
        return titlesLastName.isDisplayed();
    }

    public boolean isTitlesEmailDisplayed() {
        return titlesEmail.isDisplayed();
    }

    public CreateStudentPage clickAddStudent() {
        linkAddStudent.click();
        return new CreateStudentPage();
    }

    public boolean isStudentUpdateButtonDisplayed(int studentNumber) {
        return getStudentItemByNumber(studentNumber).isStudentButtonUpdateDisplayed();
    }

    public boolean isStudentDeleteButtonDisplayed(int studentNumber) {
        return getStudentItemByNumber(studentNumber).isStudentButtonDeleteDisplayed();
    }

    public EditStudentsPage clickUpdateStudent(int studentNumber) {
        return getStudentItemByNumber(studentNumber).clickUpdate();
    }

    public StudentsPage clickDeleteStudent(int studentNumber) {
        getStudentItemByNumber(studentNumber).clickDelete();
        return this;
    }

    public List<Student> getStudents() {
        return getStudentItems()
                .stream()
                .map(StudentItem::generateStudent)
                .collect(Collectors.toList());
    }

    public Student getStudentByNumber(int number) {
        List<StudentItem> studentItems = getStudentItems();
        return studentItems.get(number - 1)
                .generateStudent();
    }

    public boolean findStudent(Student student) {
        List<Student> students = getStudents();
        for (Student item : students) {
            if (item.getFirstName().equals(student.getFirstName())
                    && item.getLastName().equals(student.getLastName())
                    && item.getEmail().equals(student.getEmail()))
                return true;
        }
        return false;
    }

    private List<StudentItem> getStudentItems() {
        List<WebElement> allStudentsList = webDriver.findElements(StudentItem.studentItem);
        List<StudentItem> result = new ArrayList<>();
        for (WebElement student : allStudentsList) {
            result.add(new StudentItem(student));
        }
        return result;
    }

    private StudentItem getStudentItemByNumber(int studentNumber) {
        List<StudentItem> studentsItems = getStudentItems();
        if (studentsItems.get(studentNumber - 1) != null) {
            return studentsItems.get(studentNumber - 1);
        }
        throw new RuntimeException("not found");
    }

    private static class StudentItem {
        private static final By studentItem = By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr");
        private final WebElement studentInfo;

        private final By studentFirstName = By.xpath("./td[1]");
        private final By studentLastName = By.xpath("./td[2]");
        private final By studentEmail = By.xpath("./td[3]");
        private final By buttonUpdate = By.xpath("./td[4]/a[@class='btn btn-primary']");
        private final By buttonDelete = By.xpath("./td[4]/a[@class='btn btn-danger']");

        public StudentItem(WebElement student) {
            studentInfo = student;
        }

        private Student generateStudent() {
            return new Student()
                    .setFirstName(getStudentFirstName())
                    .setLastName(getStudentLastName())
                    .setEmail(getStudentEmail())
                    .setButtonUpdate(getButtonUpdate())
                    .setButtonDelete(getButtonDelete());
        }

        private String getStudentFirstName() {
            return studentInfo.findElement(studentFirstName)
                    .getText();
        }

        private String getStudentLastName() {
            return studentInfo.findElement(studentLastName)
                    .getText();
        }

        private String getStudentEmail() {
            return studentInfo.findElement(studentEmail)
                    .getText();
        }

        private WebElement getButtonUpdate() {
            return studentInfo.findElement(buttonUpdate);
        }

        private WebElement getButtonDelete() {
            return studentInfo.findElement(buttonDelete);
        }

        private EditStudentsPage clickUpdate() {
            studentInfo.findElement(buttonUpdate)
                    .click();
            return new EditStudentsPage();
        }

        private void clickDelete() {
            studentInfo.findElement(buttonDelete)
                    .click();
        }

        public boolean isStudentButtonUpdateDisplayed() {
            return studentInfo.findElement(buttonUpdate)
                    .isDisplayed();
        }

        public boolean isStudentButtonDeleteDisplayed() {
            return studentInfo.findElement(buttonDelete)
                    .isDisplayed();
        }
    }
}