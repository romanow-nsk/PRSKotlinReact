package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SATeam:Entity{
    var SAGroupRating:EntityLink<SAGroupRating> = EntityLink<SAGroupRating>()
    var teamNum:Int=0
    var students:EntityLinkList<SAStudent> = EntityLinkList<SAStudent>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
