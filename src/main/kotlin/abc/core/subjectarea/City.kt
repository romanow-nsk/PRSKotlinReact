package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class City:Entity{
    var name:String=""
    var type:Int=0
    constructor() {}
}
