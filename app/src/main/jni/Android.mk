# Make-File for the convolution code
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := sumar # Nombre de la librería, se le pone el prefijo lib automaticamente al compilar
LOCAL_SRC_FILES := com_dev_cristian_alvarez_usarcodigonativoc_ClaseNativa.c
LOCAL_CPP_FEATURES := exceptions # Incluimos las excepciones, caracteristica de C++
LOCAL_CPP_FLAGS := -std=c++11 # Utilizamos la version de C++11 para hacer la compilación

include $(BUILD_SHARED_LIBRARY)