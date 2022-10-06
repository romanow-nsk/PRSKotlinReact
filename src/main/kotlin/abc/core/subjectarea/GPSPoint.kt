package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class GPSPoint:Entity{
    var state:Int=0
    var geoy:Double=0.0
    var geox:Double=0.0
    var gpsTime:OwnDateTime=OwnDateTime()
    var parentName:String=""
    var parentOid:Long=0
    constructor() {}
}
