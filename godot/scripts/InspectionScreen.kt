@GodotScript
class InspectionScreen : Control() {

    @Export var checklistContainer: VBoxContainer? = null

    private val viewModel = InspectionViewModel()

    override fun _ready() {
        viewModel.loadDemoInspection()
        // TODO: Observe StateFlow and populate UI
        println("WorstKMP: Inspection screen ready. This is the wurst.")
    }
}
