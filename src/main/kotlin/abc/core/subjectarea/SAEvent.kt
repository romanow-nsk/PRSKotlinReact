package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAEvent:Entity{
    var SAGroupRating:EntityLink<SAGroupRating> = EntityLink<SAGroupRating>()
    var date:OwnDateTime=OwnDateTime()
    var visits:ArrayList<SAVisit> = ArrayList<SAVisit>()
    var eduUnit:EntityLink<SAEduUnit> = EntityLink<SAEduUnit>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
