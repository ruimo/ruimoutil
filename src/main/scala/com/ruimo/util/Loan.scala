package com.ruimo.util

import java.io.Closeable

object Loan {
  def withResource[R <: Closeable, V](resource: R)(f: R => V): V =
    try {
      f(resource)
    }
    finally {
      resource.close()
    }
}
