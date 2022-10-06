package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAPoint:Entity{
    var SASemesterRating:EntityLink<SASemesterRating> = EntityLink<SASemesterRating>()
    var rating:EntityLink<SAGroupRating> = EntityLink<SAGroupRating>()
    var student:EntityLink<SAStudent> = EntityLink<SAStudent>()
    var eduUnit:EntityLink<SAEduUnit> = EntityLink<SAEduUnit>()
    var point:Double=0.0
    var quality:Int=0
    var deliveryWeek:Int=0
    var date:OwnDateTime=OwnDateTime()
    var source:EntityLink<Artifact> = EntityLink<Artifact>()
    var report:EntityLink<Artifact> = EntityLink<Artifact>()
    var variant:String=""
    var state:Int=0
    constructor() {}
}
