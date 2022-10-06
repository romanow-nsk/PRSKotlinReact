package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAAnswer:Entity{
    var SAExamRating:EntityLink<SAExamRating> = EntityLink<SAExamRating>()
    var messages:EntityLinkList<SAMessage> = EntityLinkList<SAMessage>()
    var task:EntityLink<SATask> = EntityLink<SATask>()
    var rating:Int=0
    var state:Int=0
    constructor() {}
}
