package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class TableCol{
    var name:String=""
    var size:Int=0
    var hexBackColor:Int=0
    var align:Int=0
    var linkIndex:Int=0
    constructor() {}
}
