package it.kallsu.scala.gcommerce.entity

abstract class BaseEntity(val id: Long) {

  override def equals(obj: Any): Boolean = {
    if (obj == null)
      return false
    else if (!obj.isInstanceOf[BaseEntity])
      return false
    else {
      val castObj = obj.asInstanceOf[BaseEntity]

      if (castObj.id == this.id)
        return true
      else
        return false
    }
  }

  override def hashCode(): Int = {
    return (57 + id).hashCode()
  }
}
