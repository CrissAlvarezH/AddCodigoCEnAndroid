#include "com_dev_cristian_alvarez_usarcodigonativoc_ClaseNativa.h"
#include <string>
#include <sstream>
#include <android/log.h>

using namespace std;

void mostrarLog(int num1) {
    stringstream stream;

    stream << "El resultado es: " << num1;

    string log = stream.str();

    __android_log_print(ANDROID_LOG_DEBUG, "CodigoCpp", "Logs -> %s", log.c_str());
}

JNIEXPORT jint JNICALL Java_com_dev_cristian_alvarez_usarcodigonativoc_ClaseNativa_sumar
  (JNIEnv *env, jclass clazz, jint num1, jint num2) {

  jint resultado = num1 + num2;

  mostrarLog(resultado);

  return resultado;

}

