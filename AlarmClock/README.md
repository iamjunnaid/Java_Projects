
# ⏰ Java Alarm Clock

> A small, console-based alarm clock written in Java.
> Set an alarm time (HH:MM:SS), watch a live ticking clock in the console, and play a `.wav` sound when the alarm time is reached.

---


## 🔎 Overview

This project demonstrates simple use of:

* Java time API (`LocalTime`, `DateTimeFormatter`)
* Multithreading (`Runnable`, `Thread`)
* Java sound API (`javax.sound.sampled.Clip`, `AudioSystem`)
* Console I/O with `Scanner`

It is designed to be easy to read and run — good for learning how to combine time, threads, and audio in a small program.

---

## 📁 Project structure

```
Java-Alarm-Clock/
├── src/
│   ├── App.java         # main program: asks for alarm time and starts the alarm thread
│   └── AlarmClass.java  # Runnable that waits and plays the audio
├── src/your_sound.wav   # place your alarm .wav file here (recommended)
├── README.md
└── .gitignore
```

---

## 🧭 How it works (short)

1. `App.main()` asks the user for an alarm time in `HH:MM:SS` format.
2. A new `AlarmClass` instance (implements `Runnable`) is created and started on a separate thread.
3. `AlarmClass.run()` checks `LocalTime.now()` once per second and prints the live clock.
4. When current time reaches or passes the alarm time, it plays the configured `.wav` file using `Clip`.
5. User presses Enter to stop the sound.

---

## ⚙️ Configuration & tips

* **File path**

  * Windows example: `src\\your_sound.wav`
  * macOS / Linux example: `src/your_sound.wav`
* **Supported audio**: best to use PCM `.wav`. Other formats may be unsupported.
* **Java version**: Java 8+ recommended.
* **Terminal**: runs in the console/terminal. If you run from an IDE, ensure the IDE console accepts standard input (Scanner) while the thread plays audio.

---

## 🐞 Troubleshooting

* **No sound / `UnsupportedAudioFileException`**

  * Use a standard PCM `.wav` file. Convert if needed (online converters or audio tools).
* **`LineUnavailableException`**

  * Another program may be using the sound device. Close other apps or try again.
* **Time parse errors**

  * Enter time exactly as `HH:MM:SS` (for example `07:05:00`).
* **Program exits immediately**

  * Ensure `filePath` points to an existing `.wav` file. Check console messages.

---

## Checklist before running

* [ ] Java 8+ installed (`java -version`)
* [ ] `your_sound.wav` placed in `src/` (or `filePath` updated)
* [ ] `App.java` and `AlarmClass.java` compiled successfully

---

## 🧩 Example usage

```
Enter an alarm time (HH:MM:SS) : 07:30:00
Alarm set for: 07:30:00
00:01:23   <-- live clock output (updates every second)
*Alarm Noise*
Press Enter to stop the alarm:
```

---