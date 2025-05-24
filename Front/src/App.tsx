import React, { useState } from 'react';

interface ClienteDto {
    nombre: string;
    correo: string;
    telefono: string;
    // Agrega más campos según los que tengas en tu DTO
}

const ClienteForm: React.FC = () => {
    const [cliente, setCliente] = useState<ClienteDto>({
        nombre: '',
        correo: '',
        telefono: '',
    });

    const [mensaje, setMensaje] = useState<string | null>(null);
    const [error, setError] = useState<string | null>(null);
    const [loading, setLoading] = useState(false);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setCliente({
            ...cliente,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setMensaje(null);
        setError(null);
        setLoading(true);

        try {
            const response = await fetch('http://localhost:8080/cliente/crear', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(cliente),
            });

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error(errorText || 'Error al guardar el cliente');
            }

            const text = await response.text();
            setMensaje(text);
            setCliente({ nombre: '', correo: '', telefono: '' });
        } catch (err: any) {
            setError(err.message || 'Error de conexión con el servidor');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div style={{ display: 'flex', gap: '2rem' }}>
            {/* Primer div: Formulario */}
            <div>
                <h2>Crear Cliente</h2>
                <form onSubmit={handleSubmit}>
                    <div>
                        <label>Nombre:</label>
                        <input
                            type="text"
                            name="nombre"
                            value={cliente.nombre}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div>
                        <label>Correo:</label>
                        <input
                            type="email"
                            name="correo"
                            value={cliente.correo}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div>
                        <label>Teléfono:</label>
                        <input
                            type="tel"
                            name="telefono"
                            value={cliente.telefono}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <button type="submit" disabled={loading}>
                        {loading ? 'Guardando...' : 'Guardar'}
                    </button>
                </form>

                {mensaje && <p style={{ color: 'green' }}>{mensaje}</p>}
                {error && <p style={{ color: 'red' }}>{error}</p>}
            </div>

            {/* Segundo div: Puedes usarlo para mostrar datos adicionales */}
            <div>
                <h2>Información adicional</h2>
                <p>Aquí podrías mostrar una lista de clientes, logs o cualquier otro componente.</p>
            </div>
        </div>
    );
};

export default ClienteForm;
