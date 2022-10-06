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
    var examRatings:EntityRefList<SAExamRating> = EntityRefList<SAExamRating>()
    var semRatings:EntityRefList<SASemesterRating> = EntityRefList<SASemesterRating>()
    var events:EntityRefList<SAEvent> = EntityRefList<SAEvent>()
    var teams:EntityRefList<SATeam> = EntityRefList<SATeam>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
