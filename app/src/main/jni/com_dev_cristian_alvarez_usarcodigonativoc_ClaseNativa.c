#include "com_dev_cristian_alvarez_usarcodigonativoc_ClaseNativa.h"


JNIEXPORT jint JNICALL Java_com_dev_cristian_alvarez_usarcodigonativoc_ClaseNativa_sumar
  (JNIEnv *env, jclass clazz, jint num1, jint num2) {

  jint resultado = num1 + num2;

  return resultado;

}

