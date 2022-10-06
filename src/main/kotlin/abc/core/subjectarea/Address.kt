package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class Address:Entity{
    var street:EntityLink<Street> = EntityLink<Street>()
    var home:String=""
    var office:String=""
    var type:Int=0
    var location:EntityLink<GPSPoint> = EntityLink<GPSPoint>()
    var parentName:String=""
    var parentOid:Long=0
    constructor() {}
}
