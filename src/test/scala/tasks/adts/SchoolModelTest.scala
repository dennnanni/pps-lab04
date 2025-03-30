package tasks.adts

import org.junit.*
import org.junit.Assert.*
import tasks.adts.SchoolModel.*
import u03.extensionmethods.Sequences.Sequence.{cons, nil}

class SchoolModelTest:

  val schoolADT: SchoolModule = BasicSchoolModule
  import schoolADT.*

  val school = emptySchool

  @Test def testCreateSchool(): Unit =
    assertEquals(nil(), school.teachers)
    assertEquals(nil(), school.courses)

  @Test def testAddTeacherCourseToSchool(): Unit =
    val school2 = school.setTeacherToCourse(teacher("nicolas"), course("informatica"))
    assertEquals(cons("nicolas", nil()), school2.teachers)
    assertEquals(cons("informatica", nil()), school2.courses)

  @Test def testAddMultipleTeachersAndCoursesToSchool(): Unit =
    val school2 = school
      .setTeacherToCourse(teacher("nicolas"), course("informatica"))
      .setTeacherToCourse(teacher("riccardo"), course("matematica"))
      .setTeacherToCourse(teacher("giulia"), course("scienze"))
    assertEquals(cons("nicolas", cons("riccardo", cons("giulia", nil()))), school2.teachers)
    assertEquals(cons("informatica", cons("matematica", cons("scienze", nil()))), school2.courses)

  @Test def testNoDuplicatesInTeachersAndCourses(): Unit =
    val school2 = school
      .setTeacherToCourse(teacher("nicolas"), course("informatica"))
      .setTeacherToCourse(teacher("giulia"), course("matematica"))
      .setTeacherToCourse(teacher("nicolas"), course("matematica"))
    assertEquals(cons("nicolas", cons("giulia", nil())), school2.teachers)
    assertEquals(cons("informatica", cons("matematica", nil())), school2.courses)

  @Test def testGetTeacherCourses(): Unit =
    val school2 = school
      .setTeacherToCourse(teacher("nicolas"), course("informatica"))
      .setTeacherToCourse(teacher("giulia"), course("scienze"))
      .setTeacherToCourse(teacher("nicolas"), course("matematica"))
    assertEquals(cons(course("informatica"), cons(course("matematica"), nil())), school2.coursesOfATeacher(teacher("nicolas")))
