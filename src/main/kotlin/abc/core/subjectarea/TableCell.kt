package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class TableCell{
    var row:Int=0
    var col:Int=0
    var value:String=""
    var hexBackColor:Int=0
    var hexTextColor:Int=0
    var selected:Boolean=false
    var textSize:Int=0
    constructor() {}
}
