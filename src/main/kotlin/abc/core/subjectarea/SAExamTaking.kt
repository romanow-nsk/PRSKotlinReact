package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class SAExamTaking:Entity{
    var name:String=""
    var startTime:OwnDateTime=OwnDateTime()
    var duration:Int=0
    var SADiscipline:EntityLink<SADiscipline> = EntityLink<SADiscipline>()
    var oneGroup:Boolean=false
    var group:EntityLink<SAGroup> = EntityLink<SAGroup>()
    var ratings:EntityRefList<SAExamRating> = EntityRefList<SAExamRating>()
    var state:Int=0
    constructor() {}
}
