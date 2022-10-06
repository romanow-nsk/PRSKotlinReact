package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class WorkSettings:Entity{
    var MKVersion:String=""
    var dataServerFileDir:String=""
    var dataServerFileDirDefault:Boolean=false
    var convertAtrifact:Boolean=false
    var mailHost:String=""
    var mailBox:String=""
    var mailPass:String=""
    var mailSecur:String=""
    var mailPort:Int=0
    var mailToSend:String=""
    var mailNotifycation:Boolean=false
    var nodeName:String=""
    constructor() {}
}
