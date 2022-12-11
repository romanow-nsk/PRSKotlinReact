package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAGroup:Entity{
    var students:ArrayList<SAStudent> = ArrayList<SAStudent>()
    var name:String=""
    var comment:String=""
    constructor() {}
}
