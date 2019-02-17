package Data;


import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.ArrayList;

public class Database {

    private ArrayList<Teacher> teachers;
    private ArrayList<Class> classes;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> studentsa2;
    private ArrayList<Student> studentsb1;
    private ArrayList<Interval> intervals;
    private ArrayList<Group> groups;
    private ArrayList<Subject> subjects;
    private ArrayList<DateTime> times;

    private Agenda agenda;


    public Database() {

        Subject values[] = Subject.values();
        this.teachers = new ArrayList<>();
        this.classes = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.studentsa2 = new ArrayList<>();
        this.studentsb1 = new ArrayList<>();
        this.intervals = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.times = new ArrayList<>();
        this.agenda = new Agenda(lessons);

        for (Subject value : values) {
            this.subjects.add(value);
        }


        final DateTime EIGHT = new DateTime(2019, 1, 1, 8, 0, 0);       // 8:00
        final DateTime NINE = new DateTime(2019, 1, 1, 9, 0, 0);        // 9:00
        final DateTime TEN = new DateTime(2019, 1, 1, 10, 0, 0);        // 10:00
        final DateTime ELEVEN = new DateTime(2019, 1, 1, 11, 0, 0);     // 11:00
        final DateTime TWELEVE = new DateTime(2019, 1, 1, 12, 0, 0);    // 12:00
        final DateTime ONE = new DateTime(2019, 1, 1, 13, 0, 0);        // 13:00
        final DateTime TWO = new DateTime(2019, 1, 1, 14, 0, 0);        // 14:00
        final DateTime THREE = new DateTime(2019, 1, 1, 15, 0, 0);      // 15:00
        final DateTime FOUR = new DateTime(2019, 1, 1, 16, 0, 0);       // 16:00
        final DateTime FIVE = new DateTime(2019, 1, 1, 17, 0, 0);       // 17:00
        final DateTime SIX = new DateTime(2019, 1, 1, 18, 0, 0);        // 18:00

        this.times.add(EIGHT);
        this.times.add(NINE);
        this.times.add(TEN);
        this.times.add(ELEVEN);
        this.times.add(TWELEVE);
        this.times.add(ONE);
        this.times.add(TWO);
        this.times.add(THREE);
        this.times.add(FOUR);
        this.times.add(FIVE);
        this.times.add(SIX);

        final Interval FIRST_LESSON = new Interval(NINE, TEN);
        final Interval SECOND_LESSON = new Interval(TEN, ELEVEN);
        final Interval THIRD_LESSON = new Interval(ELEVEN, TWELEVE);
        final Interval FOURTH_LESSON = new Interval(TWELEVE, ONE);
        final Interval FIFTH_LESSON = new Interval(ONE, TWO);
        final Interval SIXTH_LESSON = new Interval(TWO, THREE);
        final Interval SEVENTH_LESSON = new Interval(THREE, FOUR);
        final Interval EIGHT_LESSON = new Interval(FOUR, FIVE);


        Student kees = new Student("Kees", "de", "Bruin", 19, 0, 0, 108);
        Student stijn = new Student("Stijn", "de", "Bruin", 19, 0, 0, 109);
        Student niffauw = new Student("Niffauw", "a", "Bruin", 19, 0, 0, 110);
        Student sarah = new Student("Sarah", "de", "Vos", 20, 0, 0, 111);
        Student lydia = new Student("Lydia", "de", "Vos", 18, 0, 0, 112);
        Student hans = new Student("Hans", "a", "Bruin", 21, 0, 0, 113);
        Student ella = new Student("Ella", "van", "Roodhart", 20, 0, 0, 114);
        Student john = new Student("John", "de", "Ree", 18, 0, 0, 115);
        Student jan = new Student("Jan", "van", "Hoven", 17, 0, 0, 116);
        Student stan = new Student("Stan", "de", "Vaart", 17, 0, 0, 117);
        Student stanley = new Student("Stanley", "van", "Houten", 17, 0, 0, 118);
        Student anna = new Student("Anna", "van", "Nert", 19, 0, 0, 119);
        Student lisane = new Student("Lisane", "van", "Boeken", 20, 0, 0, 120);

        Teacher maurice = new Teacher("Maurice", "", "Snoeren", 45, 0, 0, 100, Subject.PRORAMMING);
        Teacher johan = new Teacher("Johan", "", "Fakka", 43, 0, 0, 110, Subject.GRAPHICS2D);
        Teacher hansen = new Teacher("hansen", "van", "Bergen", 40, 0, 0, 130, Subject.GRAPHICS3D);
        Teacher etienne = new Teacher("Etienne", "van", "Goosens", 43, 0, 0, 140, Subject.WORKSHOP);
        Teacher pieter = new Teacher("Pieter", "Kop", "Jansen", 41, 0, 0, 150, Subject.MATH);
        Teacher jessica = new Teacher("Jessica", "van der", "Heijden", 42, 0, 0, 160, Subject.HWI);
        Teacher peter = new Teacher("Peter", "", "Kailuhu", 50, 0, 0, 170, Subject.PRORAMMING);

        Group a2 = new Group(studentsa2, "A2", maurice);
        Group b1 = new Group(studentsb1, "B1", pieter);

        this.groups.add(a2);
        this.groups.add(b1);

        Classroom classroom = new Classroom(1, 20, "LA201", false, false);
        Classroom classroom1 = new Classroom(2, 20, "LA302", false, false);
        Classroom classroom2 = new Classroom(3, 20, "LA115", false, false);
        Classroom classroom3 = new Classroom(4, 20, "LX401b", false, false);
        Classroom classroom4 = new Classroom(5, 20, "LD221", false, false);
        Classroom classroom5 = new Classroom(6, 20, "LD406", false, false);
        Classroom classroom6 = new Classroom(7, 20, "LA226", false, false);
        Classroom classroom7 = new Classroom(8, 20, "LA236", false, false);

        Data.Class classe = new Data.Class(groups, "12TIAV");

        //teachers
        this.teachers.add(maurice);
        this.teachers.add(johan);
        this.teachers.add(hansen);
        this.teachers.add(etienne);
        this.teachers.add(peter);
        this.teachers.add(pieter);
        this.teachers.add(jessica);

        //students of group a2
        this.studentsa2.add(kees);
        this.studentsa2.add(stijn);
        this.studentsa2.add(sarah);
        this.studentsa2.add(lisane);
        this.studentsa2.add(lydia);
        this.studentsa2.add(ella);

        //students of group b1
        this.studentsb1.add(hans);
        this.studentsb1.add(niffauw);
        this.studentsb1.add(jan);
        this.studentsb1.add(john);
        this.studentsb1.add(stan);
        this.studentsb1.add(stanley);
        this.studentsb1.add(anna);

        //groups of the class 12TIAV
        this.groups.add(a2);
        this.groups.add(b1);


        //class are with 2 groups or more
        this.classes.add(classe);

        // classrooms
        this.classrooms.add(classroom);
        this.classrooms.add(classroom1);
        this.classrooms.add(classroom2);
        this.classrooms.add(classroom3);
        this.classrooms.add(classroom4);
        this.classrooms.add(classroom5);
        this.classrooms.add(classroom6);
        this.classrooms.add(classroom7);

        //lesson times in hour intervals
        this.intervals.add(FIRST_LESSON);
        this.intervals.add(SECOND_LESSON);
        this.intervals.add(THIRD_LESSON);
        this.intervals.add(FOURTH_LESSON);
        this.intervals.add(FIFTH_LESSON);
        this.intervals.add(SIXTH_LESSON);
        this.intervals.add(SEVENTH_LESSON);
        this.intervals.add(EIGHT_LESSON);
    }


    public Agenda returnAgenda() {
        return this.agenda;
    }

    public ArrayList<Lesson> returnLessons() {
        return this.lessons;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);

    }

    public void addClass(Class schoolClass) {
        this.classes.add(schoolClass);
    }

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Interval> getIntervals() {
        return intervals;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public int getAmountOfGroups() {
        return this.groups.size();
    }

    public void printLessons() {
        for (Lesson l : lessons) {
            System.out.println(l);
        }
    }

    public int amountOfLessons() {
        return lessons.size();
    }

    public void deleteLesson(int i) {
        this.lessons.remove(i);
    }

    public ArrayList<DateTime> getTimes() {
        return this.times;
    }
}
