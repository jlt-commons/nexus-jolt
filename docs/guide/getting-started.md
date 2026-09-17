# Getting started

**What you'll have at the end of this page:** Jolt installed, this
project's test suite running green, and a working directory ready to
depend on `nexus-jolt` from another Jolt project.

## Install Jolt

`nexus-jolt` runs on [Jolt](https://github.com/jolt-lang/jolt), native
Clojure on Chez Scheme — no JVM anywhere. Follow Jolt's own install
instructions, then confirm:

```bash
jolt --version
```

This project declares `:jolt/min-version "0.7.24"` in `deps.edn` — an
older Jolt refuses to load it rather than running with subtly wrong
behavior.

## Clone and test

```bash
git clone https://github.com/jlt-commons/nexus-jolt
cd nexus-jolt
jolt -M:test
```

A clean run reports every test passing, zero failures, zero errors.

## Depend on it from another project

Add a pinned git coordinate to your own `deps.edn`:

```clojure
io.github.jlt-commons/nexus-jolt
{:git/url "https://github.com/jlt-commons/nexus-jolt"
 :git/sha "<the commit you want>"}
```

Then require `nexus.core` for the raw dispatch engine, or
`nexus.registry` for the atom-backed convenience API most consumers
actually use (`register-effect!`, `register-action!`, `dispatch`, and
friends).

Run `bb tasks` (or `jolt tasks` for a Jolt-language project) to see
every available command, including the site-build tasks below.
