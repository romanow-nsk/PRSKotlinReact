package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SATask:Entity{
    var SATheme:EntityLink<SATheme> = EntityLink<SATheme>()
    var taskText:String=""
    var type:Int=0
    var ownRating:Int=0
    var artifact:EntityLink<Artifact> = EntityLink<Artifact>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
