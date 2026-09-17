# nexus-jolt

A Jolt port of [nexus](https://github.com/cjohansen/nexus): data-driven
action/effect/placeholder dispatch. `nexus.core` is the dispatch engine;
`nexus.registry` is a registry-atom convenience API over it (register
effects/actions/placeholders once, `dispatch` against the accumulated
registry rather than threading a config map through every call site).

Repo name is `nexus-jolt`, not `nexus` — deliberately, to disambiguate
from upstream `cjohansen/nexus` and because the code's own namespace
prefix is `nexus.*`. Use `nexus-jolt` as the dependency name.

## How to read this guide

Start with Getting Started to run the test suite, then Architecture for
how dispatch works and why the registry exists on top of the core
engine. Contributing covers the porting conventions if you're touching
ported code.

## Guide map

| Page | What you'll learn |
|---|---|
| [Getting started](getting-started.md) | Install Jolt, run the test suite |
| [Architecture](architecture.md) | `nexus.core`'s dispatch model, and what `nexus.registry` adds |
| [Contributing](contributing.md) | Porting conventions, provenance rules, how to run tests |

## Find your scenario

| Scenario | Pages to read |
|---|---|
| "I want to try this out" | Getting started |
| "I want to understand how it works" | Architecture |
| "I want to contribute a change" | Contributing |
