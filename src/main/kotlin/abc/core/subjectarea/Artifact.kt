package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class Artifact:Entity{
    var type:Int=0
    var name:String=""
    var original:FileNameExt=FileNameExt()
    var date:OwnDateTime=OwnDateTime()
    var fileSize:Long=0
    var fileLost:Boolean=false
    var parentName:String=""
    var parentOid:Long=0
    constructor() {}
}
