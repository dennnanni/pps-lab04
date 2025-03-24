package tasks.adts

import org.junit.*
import org.junit.Assert.*
import tasks.adts.SchoolModel.*
import u03.extensionmethods.Sequences.Sequence.nil

class SchoolModelTest:

  val schoolADT: SchoolModule = BasicSchoolModule
  import schoolADT.*

  val school = emptySchool

  @Test def testCreateSchool(): Unit =
    assertEquals(nil(), school.teachers)
    assertEquals(nil(), school.courses)

