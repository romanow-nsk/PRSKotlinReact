package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAGroupRating:Entity{
    var SADiscipline:EntityLink<SADiscipline> = EntityLink<SADiscipline>()
    var examRule:EntityLink<SAExamRule> = EntityLink<SAExamRule>()
    var group:EntityLink<SAGroup> = EntityLink<SAGroup>()
    var semRule:EntityLink<SASemesterRule> = EntityLink<SASemesterRule>()
    var examRatings:ArrayList<SAExamRating> = ArrayList<SAExamRating>()
    var semRatings:ArrayList<SASemesterRating> = ArrayList<SASemesterRating>()
    var events:ArrayList<SAEvent> = ArrayList<SAEvent>()
    var teams:ArrayList<SATeam> = ArrayList<SATeam>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
