package com.andrew.schedule;

import com.andrew.schedule.controllers.*;
import com.andrew.schedule.utils.TimeConverterUtil;
import com.andrew.schedule.views.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ScheduleApplicationTests {
    private final ClassroomsController classroomsController = new ClassroomsController();
    private final CoursesController coursesController = new CoursesController();
    private final LessonsController lessonsController = new LessonsController();
    private final ProfessorsController professorsController = new ProfessorsController();
    private final StudentsController studentsController = new StudentsController();
    private final MainController mainController = new MainController();

    @Test
    public void testMain() {
        assertEquals("index", mainController.index());
    }

    @Test
    public void testCourses() {
        CoursesView coursesView = new CoursesView();
        coursesView.name = "a";
        coursesView.type = "aa";
        coursesView.year = "1111";
        coursesView.times_per_week = 1L;
        coursesView.add_students_ids = new ArrayList<>();
        coursesView.add_students_ids.add(1L);
        coursesView.add_professors_ids = new ArrayList<>();
        coursesView.add_professors_ids.add(1L);
        coursesController.add(coursesView);

        List<CoursesView> coursesViewList = coursesController.get();
        coursesView = coursesViewList.get(coursesViewList.size() - 1);
        assertEquals("a", coursesView.name);
        assertEquals("aa", coursesView.type);
        assertEquals("1111", coursesView.year);
        assert (1L == coursesView.times_per_week);

        Long id = coursesView.id;

        coursesView = new CoursesView();
        coursesView.name = "b";
        coursesView.type = "bb";
        coursesView.year = "2222";
        coursesView.times_per_week = 2L;
        coursesView.delete_students_ids = new ArrayList<>();
        coursesView.delete_students_ids.add(1L);
        coursesView.delete_professors_ids = new ArrayList<>();
        coursesView.delete_professors_ids.add(1L);
        coursesView.add_students_ids = new ArrayList<>();
        coursesView.add_students_ids.add(2L);
        coursesView.add_professors_ids = new ArrayList<>();
        coursesView.add_professors_ids.add(2L);
        coursesController.edit(id, coursesView);

        coursesViewList = coursesController.get();
        coursesView = coursesViewList.get(coursesViewList.size() - 1);
        assertEquals("b", coursesView.name);
        assertEquals("bb", coursesView.type);
        assertEquals("2222", coursesView.year);
        assert (2L == coursesView.times_per_week);

        coursesController.delete(id);
    }

    @Test
    public void testClassrooms() {
        ClassroomView classroomView = new ClassroomView();
        classroomView.number = 222L;
        classroomView.capacity = 222L;
        classroomsController.add(classroomView);

        List<ClassroomView> classroomViewList = classroomsController.getAll();
        classroomView = classroomViewList.get(classroomViewList.size() - 1);
        assert(classroomView.capacity == 222L);
        assert(classroomView.number == 222L);

        classroomsController.delete(classroomView.number);

        classroomViewList = classroomsController.getByStartTime("2000-10-10T00:00", "2200-10-10T00:00");
        assert(classroomViewList.size() == 0);

        classroomViewList = classroomsController.getByStartTime("2000-10-10T00:00", "2000-10-10T00:01");
        assert(classroomViewList.size() == 3);
    }

    @Test
    public void testProfessors() {
        ProfessorsView professorsView = new ProfessorsView();
        professorsView.name = "1";
        professorsView.surname = "1";
        professorsView.patronymic = "1";
        professorsController.add(professorsView);

        List<ProfessorsView> professorsViewList = professorsController.get(null, null, null);
        professorsView = professorsViewList.get(professorsViewList.size() - 1);
        assertEquals("1", professorsView.name);
        assertEquals("1", professorsView.surname);
        assertEquals("1", professorsView.patronymic);

        Long id = professorsView.id;

        professorsView = new ProfessorsView();
        professorsView.name = "2";
        professorsView.surname = "2";
        professorsView.patronymic = "2";
        professorsController.edit(id, professorsView);

        professorsViewList = professorsController.get("2", "2", "2");
        assert(professorsViewList.size() == 1);

        professorsController.delete(id);
    }

    @Test
    public void testStudents() {
        StudentsView studentsView = new StudentsView();
        studentsView.name = "1";
        studentsView.surname = "1";
        studentsView.patronymic = "1";
        studentsView.year = 1L;
        studentsView.group = 1L;
        studentsView.stream = 1L;
        studentsController.add(studentsView);

        List<StudentsView> studentsViewList = studentsController.get(null, null, null, null, null);
        studentsView = studentsViewList.get(studentsViewList.size() - 1);
        assertEquals("1", studentsView.name);
        assertEquals("1", studentsView.surname);
        assertEquals("1", studentsView.patronymic);
        assert(1L == studentsView.year);
        assert(1L == studentsView.group);
        assert(1L == studentsView.stream);

        Long id = studentsView.id;

        studentsView = new StudentsView();
        studentsView.name = "2";
        studentsView.surname = "2";
        studentsView.patronymic = "2";
        studentsView.year = 2L;
        studentsView.group = 2L;
        studentsView.stream = 2L;
        studentsController.edit(id, studentsView);

        studentsViewList = studentsController.get("2", "2", "2", 2L, 2L);
        assert(1 == studentsViewList.size());

        studentsController.delete(id);
    }

    @Test
    public void testLessons() {
        LessonsView lessonsView = new LessonsView();
        lessonsView.course_id = 1L;
        lessonsView.classroom_number = 1L;
        lessonsView.start_time = TimeConverterUtil.fromString("1000-12-22T00:00");
        lessonsController.add(lessonsView);


        List<LessonsView> lessonsViewList = lessonsController.getByClassroomAndTime(1L, "1000-11-22T00:00", "1000-12-24T00:00");
        assert(1 == lessonsViewList.size());
        lessonsViewList = lessonsController.getByProfessorIdAndTime(1L,  "1000-11-22T00:00", "1000-12-24T00:00");
        assert(1 == lessonsViewList.size());
        lessonsViewList = lessonsController.getByStudentIdAndTime(1L,  "1000-11-22T00:00", "1000-12-24T00:00");
        assert(1 == lessonsViewList.size());

        lessonsController.delete(lessonsViewList.get(lessonsViewList.size()-1).id);
    }
}
