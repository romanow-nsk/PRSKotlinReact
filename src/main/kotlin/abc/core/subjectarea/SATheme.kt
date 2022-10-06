package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SATheme:Entity{
    var SADiscipline:EntityLink<SADiscipline> = EntityLink<SADiscipline>()
    var tasks:EntityRefList<SATask> = EntityRefList<SATask>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
