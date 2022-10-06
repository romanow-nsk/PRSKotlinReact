package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class FileNameExt{
    var path:String=""
    var name:String=""
    var ext:String=""
    constructor() {}
}
