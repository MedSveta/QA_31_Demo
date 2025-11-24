package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);
        Student student = new Student("Vasya", "Vasilev", "vasyavasilev@gmail.com",
                Gender.MALE, "0123456789", "23 Dec 2006", "Maths,Physics,Chemistry",
                hobbies, "", "address 1", StateCity.UTTAR_PRADESH.getState(),
                StateCity.UTTAR_PRADESH.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        Assert.assertTrue(new PracticeFormPage(getDriver())
                .validateModalMessage("Thanks for submitting the form"));
    }
}
