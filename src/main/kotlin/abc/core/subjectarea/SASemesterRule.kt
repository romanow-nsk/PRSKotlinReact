package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SASemesterRule:Entity{
    var smstrDate:OwnDateTime=OwnDateTime()
    var semesterDuration:Int=0
    var fineOverDate:Boolean=false
    var overDateWeeks:Int=0
    var overDatePercent:Int=0
    var fineOverSemester:Boolean=false
    var overSemesterPercent:Int=0
    var fineOverIrregular:Boolean=false
    var irregulaFirstWeek:Int=0
    var pointPerSkip:Double=0.0
    var qualProc:Int=0
    var name:String=""
    var comment:String=""
    constructor() {}
}
