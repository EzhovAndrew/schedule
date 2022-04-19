package com.andrew.schedule;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;


public class SeleniumTests {
    String URL = "http://localhost:8080/";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void settings() {
        final String ffDriver = "/usr/bin/geckodriver";
        System.setProperty("webdriver.gecko.driver", ffDriver);
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1000, 800));
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
    }

    @Test(priority=1)
    public void mainPageTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("a.navbar-brand")));
        Assert.assertEquals(driver.getTitle(), "Учебное расписание");
        button.click();
        wait.until(stalenessOf(button));

        wait.until(visibilityOfElementLocated(By.cssSelector("a.navbar-brand")));
        Assert.assertEquals(driver.getTitle(), "Учебное расписание");

        WebElement grretings = driver.findElement(By.cssSelector("div.greetings > p"));
        Assert.assertEquals(grretings.getText(), "Добро пожаловать!");

        driver.findElement(By.cssSelector("img[alt=book]"));
    }

    @Test(priority=2)
    public void studentsAddTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-btn-students")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление объекта");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToAddStudent")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление студента");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("StudentNameFieldInput")).sendKeys("seleniumStudent");
        driver.findElement(By.id("StudentSurnameFieldInput")).sendKeys("seleniumStudent");
        driver.findElement(By.id("StudentPatronymicFieldInput")).sendKeys("seleniumStudent");
        driver.findElement(By.id("StudentGroupFieldInput")).sendKeys("328");
        driver.findElement(By.id("StudentStreamFieldInput")).sendKeys("3");
        driver.findElement(By.id("StudentYearFieldInput")).sendKeys("3");

        button = driver.findElement(By.id("formStudentAddButton"));
        button.click();
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Добавление студента"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Студент успешно добавлен!"));
    }

    @Test(priority=3)
    public void studentsGetEditDeleteTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-btn-students")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение объектов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetStudents")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение студентов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("StudentNameFieldInput")).sendKeys("seleniumStudent");
        driver.findElement(By.id("StudentSurnameFieldInput")).sendKeys("seleniumStudent");
        driver.findElement(By.id("StudentPatronymicFieldInput")).sendKeys("seleniumStudent");
        driver.findElement(By.id("StudentGroupFieldInput")).sendKeys("328");
        driver.findElement(By.id("StudentStreamFieldInput")).sendKeys("3");

        button = driver.findElement(By.id("formStudentsGetButton"));
        button.click();
        wait.until(visibilityOfElementLocated(By.cssSelector("div.card")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение студентов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Данные успешно загружены!");

        button = driver.findElement(By.cssSelector("button.btn-close"));
        button.click();
        button = driver.findElement(By.cssSelector("button[button-editor]"));
        button.click();
        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToEditStudent")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Редактирование студента");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");
        driver.findElement(By.id("StudentNameFieldInput")).sendKeys("seleniumStudent2");
        driver.findElement(By.id("StudentSurnameFieldInput")).sendKeys("seleniumStudent2");
        driver.findElement(By.id("StudentPatronymicFieldInput")).sendKeys("seleniumStudent2");
        button = driver.findElement(By.cssSelector("button[type=submit]"));
        button.click();
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Редактирование студента"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Данные о студенте успешно обновлены!"));
        button = driver.findElement(By.cssSelector("button.btn-close"));
        button.click();

        button = driver.findElement(By.cssSelector("button[button-deleter]"));
        button.click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".container-md")).getText(), "");
    }


    @Test(priority=4)
    public void studentsGetNoneTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-btn-students")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение объектов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetStudents")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение студентов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("StudentNameFieldInput")).sendKeys("Abrakadabra");
        driver.findElement(By.id("StudentSurnameFieldInput")).sendKeys("Ezhov");
        driver.findElement(By.id("StudentPatronymicFieldInput")).sendKeys("Vladimirovich");
        driver.findElement(By.id("StudentGroupFieldInput")).sendKeys("");
        driver.findElement(By.id("StudentStreamFieldInput")).sendKeys("3");

        button = driver.findElement(By.id("formStudentsGetButton"));
        button.click();
        WebElement container = wait.until(visibilityOfElementLocated(By.cssSelector("div.container-md")));
        wait.until(textToBePresentInElement(container, "По вашему запросу ничего не нашлось."));
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Получение студентов"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Данные успешно загружены!"));
    }

    @Test(priority=5)
    public void  profsAddTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-btn-profs")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление объекта");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToAddProf")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление преподавателя");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("ProfNameFieldInput")).sendKeys("seleniumProfessor");
        driver.findElement(By.id("ProfSurnameFieldInput")).sendKeys("seleniumProfessor");
        driver.findElement(By.id("ProfPatronymicFieldInput")).sendKeys("seleniumProfessor");

        button = driver.findElement(By.id("formProfAddButton"));
        button.click();

        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Добавление преподавателя"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Преподаватель успешно добавлен!"));
    }

    @Test(priority=6)
    public void profsGetEditDeleteTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-btn-profs")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение объектов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetProfs")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение преподавателей");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("ProfNameFieldInput")).sendKeys("seleniumProfessor");
        driver.findElement(By.id("ProfSurnameFieldInput")).sendKeys("seleniumProfessor");
        driver.findElement(By.id("ProfPatronymicFieldInput")).sendKeys("seleniumProfessor");

        button = driver.findElement(By.id("formProfsGetButton"));
        button.click();
        wait.until(visibilityOfElementLocated(By.cssSelector("div.card")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение преподавателей");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Данные успешно загружены!");

        button = driver.findElement(By.cssSelector("button.btn-close"));
        button.click();
        button = driver.findElement(By.cssSelector("button[button-editor]"));
        button.click();
        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToEditProf")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Редактирование преподавателя");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");
        driver.findElement(By.id("ProfSurnameFieldInput")).sendKeys("seleniumProfessor2");
        driver.findElement(By.id("ProfPatronymicFieldInput")).sendKeys("seleniumProfessor2");
        button = driver.findElement(By.cssSelector("button[type=submit]"));
        button.click();
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Редактирование преподавателя"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Данные о преподавателе успешно обновлены!"));
        button = driver.findElement(By.cssSelector("button.btn-close"));
        button.click();
        button = driver.findElement(By.cssSelector("button[button-deleter]"));
        button.click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".container-md")).getText(), "");
    }

    @Test(priority=7)
    public void profsGetNoneTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-btn-profs")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение объектов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetProfs")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение преподавателей");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("ProfNameFieldInput")).sendKeys("Abrakadabra");
        driver.findElement(By.id("ProfSurnameFieldInput")).sendKeys("");
        driver.findElement(By.id("ProfPatronymicFieldInput")).sendKeys("");

        button = driver.findElement(By.id("formProfsGetButton"));
        button.click();
        WebElement container = wait.until(visibilityOfElementLocated(By.cssSelector("div.container-md")));
        Assert.assertEquals(container.getText(), "По вашему запросу ничего не нашлось.");
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение преподавателей");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Данные успешно загружены!");
    }

    @Test(priority=8)
    public void courseAddTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-btn-courses")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление объекта");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToAddCourse")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление курса");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("CourseAddNameFieldInput")).sendKeys("seleniumCourse");
        driver.findElement(By.id("CourseAddNumInPeriodFieldInput")).sendKeys("3");
        driver.findElement(By.id("CourseAddYearFieldInput")).sendKeys("2022");

        button = driver.findElement(By.id("formCourseAddButton"));
        button.click();
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Добавление курса"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Курс успешно добавлен!"));
    }

    @Test(priority=9)
    public void coursesGetEditDeleteTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-btn-courses")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение объектов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("div.card")));
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Получение объектов"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Данные успешно загружены!"));
        button = driver.findElement(By.cssSelector("button.btn-close"));
        button.click();

        button = driver.findElement(By.cssSelector("button[button-editor]"));
        button.click();
        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToEditCourse")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Редактирование курса");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");
        driver.findElement(By.id("CourseAddNameFieldInput")).sendKeys("seleniumCourse2");
        driver.findElement(By.id("CourseAddNumInPeriodFieldInput")).clear();
        driver.findElement(By.id("CourseAddNumInPeriodFieldInput")).sendKeys("5");
        driver.findElement(By.id("CourseAddYearFieldInput")).clear();
        driver.findElement(By.id("CourseAddYearFieldInput")).sendKeys("2021");
        button = driver.findElement(By.cssSelector("button[type=submit]"));
        button.click();
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Редактирование курса"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Курс успешно обновлен!"));
        button = driver.findElement(By.cssSelector("button.btn-close"));
        button.click();
        button = driver.findElement(By.cssSelector("button[button-deleter]"));
        button.click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".container-md")).getText(), "");
    }

    @Test(priority=10)
    public void classroomAddTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-btn-classrooms")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление объекта");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToAddClassroom")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление аудитории");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("ClassroomNumFieldInput")).sendKeys("310");
        driver.findElement(By.id("classroomCapacityFieldInput")).sendKeys("20");

        button = driver.findElement(By.id("formСlassroomAddButton"));
        button.click();

        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Добавление аудитории"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Аудитория успешно добавлена!"));
    }

    @Test(priority=11)
    public void ClassroomsGetTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-btn-classrooms")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getAttribute("innerHTML"), "Получение объектов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getAttribute("innerHTML"), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetClassrooms")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getAttribute("innerHTML"), "Получение списка аудиторий");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getAttribute("innerHTML"), "Заполните форму");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(`#ClassroomsStartFieldInput`).setAttribute('value', '2022-04-19T00:00')");
        js.executeScript("document.querySelector(`#ClassroomsEndFieldInput`).setAttribute('value', '2022-04-20T00:00')");

        button = driver.findElement(By.id("formClassroomsGetButton"));
        button.click();
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Получение списка аудиторий"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Данные успешно загружены!"));
    }

    @Test(priority=12)
    public void lessonsAddTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Add-btn-lessons")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление объекта");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();

        wait.until(visibilityOfElementLocated(By.cssSelector("#FormToAddLesson")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Добавление занятия");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Заполните форму");

        driver.findElement(By.id("courseIdFieldInput")).sendKeys("1");
        driver.findElement(By.id("courseClassroomNumFieldInput")).sendKeys("310");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(`#LessonStartFieldInput`).setAttribute('value', '2022-04-19T00:00')");

        button = driver.findElement(By.id("formLessonAddButton"));
        button.click();
        wait.until(textToBePresentInElement(By.cssSelector("h5.modal-title"), "Добавление занятия"));
        wait.until(textToBePresentInElement(By.cssSelector("#modal-hint"), "Возникла ошибка. Попробуйте еще раз или перезагрузите страницу"));
    }

    @Test(priority=13)
    public void lessonsGetTest() {
        driver.get(URL);

        WebElement button = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-button")));
        button.click();
        WebElement getButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Get-btn-lessons")));
        Assert.assertEquals(driver.findElement(By.cssSelector("h5.modal-title")).getText(), "Получение объектов");
        Assert.assertEquals(driver.findElement(By.cssSelector("#modal-hint")).getText(), "Нажмите на кнопку желаемого объекта");
        getButton.click();
        WebElement button1 = driver.findElement(By.cssSelector("#Get-btn-lessons-students"));
        WebElement button2 = driver.findElement(By.cssSelector("#Get-btn-lessons-profs"));
        WebElement button3 = driver.findElement(By.cssSelector("#Get-btn-lessons-classrooms"));

        int num = new Random().nextInt(3) + 1;
        if (num == 1) {
            button1.click();
            wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetStudentSchedule")));
        } else if (num == 2) {
            button2.click();
            wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetProfSchedule")));
        } else {
            button3.click();
            wait.until(visibilityOfElementLocated(By.cssSelector("#FormToGetClassroomSchedule")));
        }
    }

    @AfterClass
    public void end() {
        driver.quit();
    }
}
