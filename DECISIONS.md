# Decision Log – WorstKMP PDF Map Prototype

This file records important architectural and design decisions made during development.  
The goal is to improve long-term understanding, make it easier to revisit choices later, and support active recall.

Each entry includes:
- **Date**
- **Decision**
- **Why** (reasoning and goals)
- **Trade-offs / Considerations**
- **Related Files / Code**

---

## 2026-05-19 – HomeScreen Tab State Management

**Decision:**  
Use a `HomeUiState` data class inside `HomeScreenViewModel` with `mutableStateOf` and `private set`, instead of managing `selectedTab` directly inside the Composable or using a simple `var`.

**Why:**
- Keeps UI state ownership inside the ViewModel (aligns with Simple Architecture / MVVM).
- Makes the state observable and easy to read from the UI using delegation or direct access.
- Prepares the structure for future expansion (loading states, recent PDFs, tutorial visibility, etc.).
- Encourages keeping screens thin and focused on rendering.
- Supports better testability and predictability when state changes.

**Trade-offs / Considerations:**
- Slightly more boilerplate than putting state directly in the screen.
- Requires creating a data class and using `.copy()` for updates.
- Worth the small extra effort for clarity, maintainability, and following the architecture we defined.

**Related Files:**
- `composeApp/src/commonMain/kotlin/com/worstkmp/presentation/viewmodel/HomeScreenViewModel.kt`
- `composeApp/src/commonMain/kotlin/com/worstkmp/ui/screens/HomeScreen.kt`

---

## Template for Future Entries

Copy the format below when adding new decisions:

```markdown
## YYYY-MM-DD – Short Decision Title

**Decision:**  
[What was decided]

**Why:**  
[Reasoning and goals]

**Trade-offs / Considerations:**  
[What we considered, pros/cons]

**Related Files:**  
- File paths or key code references