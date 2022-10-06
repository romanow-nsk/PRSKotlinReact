package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class ReportFile:Entity{
    var reportHeader:String=""
    var reportType:Int=0
    var archive:Boolean=false
    var artifact:EntityLink<Artifact> = EntityLink<Artifact>()
    constructor() {}
}
