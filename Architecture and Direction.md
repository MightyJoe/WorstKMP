WorstKMP

# Architecture plan

Goal
- Stability, testability, and performance by decoupling UI, business logic, and data sources.
- Establish a predictable, maintainable codebase aligned with KMP modern best practices.

Target Architecture (Simple Architecture with MVVM)
- Presentation layer ( These live in composeApp ):
  - Screens are thin, render-only.
  - ViewModels own UI state and orchestrate use-cases via injected repositories.
  - Navigation via a single source (voyager), with managed back-stack. 
- Domain layer ( These live in shared ):
  - Use-cases (interactors) encapsulate business logic in small, testable units.
  - No framework types; pure Kotlin where possible.
- Data layer ( mostly lives in shared ):
  - Repositories expose suspend functions/Flows.
  - Sources: User touch input (or mouse if desktop) for data point entry, Location for tracks and calibration, Network (eventually, not phase 1), Bluetooth (Kable, Blue-Falcon, or other) to talk to GPS Units eventually (not phase 1), Local DB (SQLDelight) for app state, layers, etc., Filesystem (for PDFs).
  - Mapping to domain models lives here.

Key Cross-cutting Concerns
- Dependency Injection: (Koin) for provisioning ViewModels, use-cases, repositories, data sources, and system services.
- Concurrency: Kotlin Coroutines + Flow; lifecycleScope/viewModelScope for UI, Dispatchers.IO for IO-bound operations.
- Background services: For uploading files/images even if the application closes, or loses internet and closes and then comes back into internet range, etc.
- Logging/Telemetry: Structured logging + crash reporting; central feedback/log uploader/viewer with backoff and dedupe. We should be able to view what happened within the app, and also upload that file if nessesary.
- Permissions: Centralized permission handler that can be tested, and attempts to maintain single responsibility.
- Navigation: The application should attempt to continue where the user left off even if the app crashed or was closed. It obviously should only retry to load where the user was once, and if crash persists (in case of crash) it should start fresh.
- Configuration: Feature flags and options through database?

Modern Android Best Practices to Adopt
- Avoid allowMainThreadQueries; Room access is suspend/Flow, executed off main thread.
- Replace AsyncTask/Thread with Coroutines.
- Binding with StateFlow, mutableStateOf, etc. between ViewModels (presentation) and View.
- Material themeing needs to be in its own place and everything needs to be covered. No generic buttons. WorstButton, or WorstTextBox, etc.
For later:
- Replace HttpsURLConnection/BroadcastReceivers plumbing with Retrofit + OkHttp + WorkManager + structured events or some other more modern and simple means.
- Migrate image compression and EXIF handling to a dedicated ImageRepository if best practice.
- Bluetooth stack encapsulated in a BluetoothRepository with clearly defined state machine and Flow-based signal strength/connection state.
- Use EncryptedSharedPreferences or Android Keystore-backed solutions via a SecurityRepository; inject credentials only where needed.

Suggested Modules (gradual, can remain a single module initially)
- :app (UI, DI, navigation)
- :domain (use-cases, models, no Android deps)
- :data (repositories, Room entities/DAOs, Retrofit, Bluetooth adapters, file IO)
- :common (logging, result wrappers, utilities)
Note: Use modern most professional best practices

Performance
- App start should be very quick with a splash screen that fades or does something like that. Everything should load after the app has started. No pre-loading slow junk.
- Offload all IO to coroutines never block the main thread.
- Every UI element that must load dynamic data of any kind ought to start as a spinner/animatedStub until the data is loaded. The page should load super fast and populate stubs until things are loaded so that the UI isn't jumping around.
- Batch uploads.
- Lazy load heavy assets.
- Performance is a top priority.

Learning and notes
- Comments should not only tell what something does, but why it is there and how to understand it (where applicable)
- Comments are only required where meaning is not obvious. Getters and setters etc. don't need comments unless DI used, or use of get/set unclear.

Logging
- Logging should show what is clicked on when, and what is loaded when on what page and what files are stored or sent.
- Crashes and method names should be shown de-obvuscated if not security related. This is an open source app anyway.
- Communication to Bluetooth devices should show SND: and RCV: and clearly describe intent if using protobuf or similar.
- HTTPS or similar GET and POST requests should show return status code, and info and describe intent as well.
- Multiple logs or tagged logs should be agreed on.

Adoption Notes
- Incremental changes are key; use feature flags and repository façades to avoid regressions.
- Start with the biggest ROI items: Simple Architecture, SQLDelight, voyager navigation, DI, and best practices from the get go.
- Keep UI rendering simple and predictable via UiState + one-shot events where possible.

This document is intended as the living blueprint for the worst PDF Map app. Update as needed.

