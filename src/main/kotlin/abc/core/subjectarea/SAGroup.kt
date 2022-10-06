package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAGroup:Entity{
    var students:EntityRefList<SAStudent> = EntityRefList<SAStudent>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
