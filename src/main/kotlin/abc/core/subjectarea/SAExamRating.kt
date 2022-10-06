package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAExamRating:Entity{
    var SAGroupRating:EntityLink<SAGroupRating> = EntityLink<SAGroupRating>()
    var SAExamTaking:EntityLink<SAExamTaking> = EntityLink<SAExamTaking>()
    var student:EntityLink<SAStudent> = EntityLink<SAStudent>()
    var semRating:EntityLink<SASemesterRating> = EntityLink<SASemesterRating>()
    var questionRating:Int=0
    var excerciceRating:Int=0
    var answers:EntityRefList<SAAnswer> = EntityRefList<SAAnswer>()
    var state:Int=0
    constructor() {}
}
