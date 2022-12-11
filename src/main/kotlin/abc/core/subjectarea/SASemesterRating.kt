package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SASemesterRating:Entity{
    var SAGroupRating:EntityLink<SAGroupRating> = EntityLink<SAGroupRating>()
    var student:EntityLink<SAStudent> = EntityLink<SAStudent>()
    var points:ArrayList<SAPoint> = ArrayList<SAPoint>()
    var team:EntityLink<SATeam> = EntityLink<SATeam>()
    var semesterRating:Int=0
    var state:Int=0
    constructor() {}
}
