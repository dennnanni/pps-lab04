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