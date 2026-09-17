(ns nexus.registry
  "Registry-atom convenience API over nexus.core, a Jolt port of
  nexus.registry (https://github.com/cjohansen/nexus), commit
  5f6c93672f25d2a5b2a91ac3b65a921ecf8826b2. Copyright 2025 Christian
  Johansen, Magnar Sveen, Teodor Heggelund. MIT License — see NOTICE.

  Byte-for-byte port — no adaptations needed, pure atom + map
  operations, no reader conditionals in the source. Mirrors the same
  atom-based register!/dispatch extensibility pattern
  jlt-commons/glitter's own glitter.widget established, in the project
  this was originally extracted from.

  Originally extracted from jlt-commons/glitter as
  glitter.nexus.registry; renamed to match upstream's own namespace
  name now that it stands alone. See NOTICE for the full history."
  (:require [nexus.core :as nexus]))

(def ^:no-doc !registry (atom {}))

(defn register-system->state! [f]
  (swap! !registry assoc :nexus/system->state f))

(defn register-system+dispatch-data->state! [f]
  (swap! !registry assoc :nexus/system+dispatch-data->state f))

(defn ^{:indent 1} register-action! [action-k f]
  (swap! !registry assoc-in [:nexus/expansions action-k] f))

(defn ^{:indent 1} register-expansion! [action-k f]
  (swap! !registry assoc-in [:nexus/expansions action-k] f))

(defn ^{:indent 1} register-effect! [effect-k f]
  (swap! !registry assoc-in [:nexus/effects effect-k] f))

(defn ^{:indent 1} register-placeholder! [placeholder-k f]
  (swap! !registry assoc-in [:nexus/placeholders placeholder-k] f))

(defn ^{:indent 1} register-interceptor!
  ([phase f]
   (register-interceptor! {phase f}))
  ([interceptor]
   (swap! !registry update :nexus/interceptors (fnil conj []) interceptor)))

(defn get-interceptors []
  (:nexus/interceptors @!registry))

(defn get-registry []
  @!registry)

(defn on-error [f]
  (swap! !registry assoc :nexus/on-error f))

(defn dispatch [system dispatch-data actions]
  (nexus/dispatch (get-registry) system dispatch-data actions))
