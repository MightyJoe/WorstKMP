// import UIKit
// import SwiftUI
// import ComposeApp
//
// struct ComposeView: UIViewControllerRepresentable {
//     func makeUIViewController(context: Context) -> UIViewController {
//         MainViewControllerKt.MainViewController()
//     }
//
//     func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
// }
//
// struct ContentView: View {
//     var body: some View {
//         ComposeView()
//             .ignoresSafeArea()
//     }
// }
//
//
//
import SwiftUI
import ComposeApp   // ← Must match baseName in build.gradle.kts

struct ContentView: View {
    var body: some View {
        MainViewControllerKt.MainViewController()
            .ignoresSafeArea(edges: .all)
    }
}

#Preview {
    ContentView()
}